package com.example.duan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.duan1.Fragment.Add_Tknhanvien;
import com.example.duan1.Fragment.Qly_DanhMuc;
import com.example.duan1.Fragment.Qly_HoaDon;
import com.example.duan1.Fragment.Qly_HoaDonChiTiet;
import com.example.duan1.Fragment.Qly_SanPham;
import com.example.duan1.Fragment.Qly_TKnhanvien;
import com.example.duan1.Fragment.Thongke;
import com.google.android.material.navigation.NavigationView;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawLayout;
    private Toolbar toolbar;
    private NavigationView nvView;
    private View mHeaderView;
    private TextView tvUser;
    ActionBarDrawerToggle toggle;

    private static final int FRAGMENT_QlySanPham = 0;
    private static final int FRAGMENT_QlyDanhMuc = 1;
    private static final int FRAGMENT_QlyHoaDon = 2;
    private static final int FRAGMENT_QlyHoaDonChiTiet = 3;
    private static final int FRAGMENT_thongke = 4;
    private static final int FRAGMENT_Add_tkNhanvien = 5;
    private static final int FRAGMENT_TKnhanvien = 6;

    int current = FRAGMENT_QlySanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawLayout = (DrawerLayout) findViewById(R.id.draw_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nvView = (NavigationView) findViewById(R.id.navigation);
        //set toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //Tao icon menu ba gach
        toggle = new ActionBarDrawerToggle(MainActivity.this,drawLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawLayout.addDrawerListener(toggle);//dua togle vao drawerlayout
        toggle.syncState();//dong bo hoa


        //navigationView lang nghe su kien
        nvView.setNavigationItemSelectedListener(this);
//        //set PhieuMuonFragment lam home
        replaceFragment(new Qly_SanPham());

        //lay ra header cua navigation view de set text
        mHeaderView = nvView.getHeaderView(0);
        tvUser = mHeaderView.findViewById(R.id.tv_user);
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        tvUser.setText(user);

        //admin co quyen add user
        if (user.equals("admin")){
            nvView.getMenu().findItem(R.id.admin).setVisible(true);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_sanPham:
                setTitle("Quản Lý Sản phẩm");
                if (current!=FRAGMENT_QlySanPham){
                    replaceFragment(new Qly_SanPham());
                    current=FRAGMENT_QlySanPham;
                }
                break;
            case R.id.nav_danhMucSp:
                setTitle("Quản Lý Danh Mục Sản Phẩm");
                if (current!=FRAGMENT_QlyDanhMuc){
                    replaceFragment(new Qly_DanhMuc());
                    current=FRAGMENT_QlyDanhMuc;
                }
                break;
            case R.id.nav_HoaDon:
                setTitle("Quản Lý Hóa Đơn");
                if (current!=FRAGMENT_QlyHoaDon) {
                    replaceFragment(new Qly_HoaDon());
                    current = FRAGMENT_QlyHoaDon;
                }
                break;
            case R.id.nav_HoaDonChiTiet:
                setTitle("Quản Lý Hóa Đơn Chi Tiết");
                if (current!=FRAGMENT_QlyHoaDonChiTiet) {
                    replaceFragment(new Qly_HoaDonChiTiet());
                    current = FRAGMENT_QlyHoaDonChiTiet;
                }
                break;
            case R.id.sub_thongke:
                setTitle("Thống Kê");
                if (current!=FRAGMENT_thongke) {
                    replaceFragment(new Thongke());
                    current = FRAGMENT_thongke;
                }
                break;
            case R.id.sub_addUser:
                setTitle("Thêm Nhân Viên");
                if (current!= FRAGMENT_Add_tkNhanvien) {
                    replaceFragment(new Add_Tknhanvien());
                    current = FRAGMENT_Add_tkNhanvien;
                }
                break;
            case R.id.sub_danhsachTK:
                setTitle("Danh Sách Nhân Viên");
                if (current!=FRAGMENT_TKnhanvien) {
                    replaceFragment(new Qly_TKnhanvien());
                    current = FRAGMENT_TKnhanvien;
                }
                break;
            case R.id.sub_logout:
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        drawLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction =fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout,fragment).commit();
        }
    @Override
    public void onBackPressed() {
        if(drawLayout.isDrawerOpen(GravityCompat.START)){
            drawLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
