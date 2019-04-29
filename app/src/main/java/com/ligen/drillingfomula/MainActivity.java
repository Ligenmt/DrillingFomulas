package com.ligen.drillingfomula;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.ligen.drillingfomula.dao.Favourite;
import com.ligen.drillingfomula.dao.FavouriteDao;
import com.ligen.drillingfomula.fragment.HomeFragment;
import com.ligen.drillingfomula.fragment.MenuFragment;
import com.ligen.drillingfomula.fragment.submenufragment.FavouriteMenuFragment;

import java.util.List;

public class MainActivity extends SlidingFragmentActivity implements
        View.OnClickListener {

    private SlidingMenu sm;
    private MenuFragment menuFragment;
    private HomeFragment homeFragment;

//    @ViewInject(R.id.btn_title_left)
    private Button btnTitleLeft;
//    @ViewInject(R.id.btn_title_right)
    private Button btnTitleRight;
//    @ViewInject(R.id.title_bar_text)
    private TextView tvTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.content);
        setBehindContentView(R.layout.menu);
//        ViewUtils.inject(this);
        btnTitleLeft = (Button) findViewById(R.id.btn_title_left);
        btnTitleRight = (Button) findViewById(R.id.btn_title_right);
        tvTitle = (TextView) findViewById(R.id.title_bar_text);

        initSlidingMenu();
        setListener();
        // 主界面
        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, homeFragment).commit();
        // 菜单界面
        menuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.menu_frame, menuFragment).commit();

    }

    private void setListener() {
        btnTitleLeft.setOnClickListener(this);
        btnTitleRight.setOnClickListener(this);

    }

    /**
     * SlidingMenu初始化
     */
    private void initSlidingMenu() {
        sm = getSlidingMenu();
        sm.setMode(SlidingMenu.LEFT);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setShadowWidth(10);
        sm.setBehindOffset(80);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        sm.setMenu(R.layout.menu);
    }

    /**
     * 进入下级菜单,从MenuFragment调用
     *
     * @param f
     */
    public void switchMenuFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.fly_in_left, R.anim.fly_out_left)
                .replace(R.id.menu_frame, f).commit();
    }

    /**
     * 返回上一级菜单
     */
    public void goBack() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.fly_in_right, R.anim.fly_out_right)
                .replace(R.id.menu_frame, menuFragment).commit();

    }

    /**
     * 切换计算界面
     * @param f
     * @param titleName
     */
    public void switchCalFragment(Fragment f, String titleName) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, f).commit();
        tvTitle.setText(titleName);
        sm.toggle();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            // 打开菜单
            case R.id.btn_title_left:
                sm.toggle();
                break;
            // 收藏
            case R.id.btn_title_right:
                Fragment fragment = getSupportFragmentManager().findFragmentById(
                        R.id.content_frame);
                String className = fragment.getClass().getName();
                String titleName = tvTitle.getText().toString();

                if ("com.ligenmt.drillingformula.fragment.HomeFragment"
                        .equals(className) || "com.ligenmt.drillingformula.fragment.AboutFragment".equals(className)) {
                    Toast.makeText(this, "这一页不能收藏哟", Toast.LENGTH_SHORT).show();
                    break;
                }
                //检查是否收藏
                boolean isCollected = false;
                FavouriteDao dao = new FavouriteDao(this);
                List<Favourite> all = dao.findAll();
                for (Favourite f : all) {
                    if (f.getTitleName().equals(titleName)) {
                        isCollected = true;
                        break;
                    }
                }
                //若已经收藏，则取消收藏
                if (isCollected) {
                    dao.delete(titleName);
                    Toast.makeText(this, "取消收藏！", Toast.LENGTH_SHORT).show();

                    //若此时菜单为收藏夹，则刷一下，若不是就不用刷了，下次进来自动更新菜单
                    Fragment menuFragment = getSupportFragmentManager().findFragmentById(
                            R.id.menu_frame);
                    if(menuFragment instanceof FavouriteMenuFragment) {
                        ((FavouriteMenuFragment)menuFragment).updateList();
                    }
                } else {
                    //若还未收藏，则收藏之
                    dao.add(titleName, className, null);
                    Toast.makeText(this, "收藏成功！", Toast.LENGTH_SHORT).show();

                }
                break;
            default:
                break;
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("退出").setMessage("确定要退出吗?");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
