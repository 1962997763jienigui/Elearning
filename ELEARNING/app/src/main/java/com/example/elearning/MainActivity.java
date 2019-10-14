package com.example.elearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup r_group;
    private RadioButton list;
    private ListFragment listFragment;
    private MoreFragment moreFragment;
    private BrowseFragment browseFragment;
    private FragmentManager fManager;
    private course_content_fragment contentFragment;
    private ArrayList<Data> courses = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fManager = getSupportFragmentManager();
        r_group = (RadioGroup) findViewById(R.id.r_group);
        r_group.setOnCheckedChangeListener(this);
        //获取第一个单选按钮，并设置其为选中状态
        list = (RadioButton) findViewById(R.id.list);
        list.setChecked(true);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (i){
            case R.id.list:
                if(listFragment == null){
                    courses = new ArrayList<Data>();
                    for (int j=1; j<=20;j++){
                        Data data = new Data("courses name" + j,   j+"detailed course introductions");
                        courses.add(data);
                    }
                    listFragment = new ListFragment(fManager,courses);
                    fTransaction.add(R.id.ly_content,listFragment);
                }else{
                    fTransaction.show(listFragment);
                }
                break;
            case R.id.search:
                if(browseFragment == null){
                    browseFragment = new BrowseFragment();
                    fTransaction.add(R.id.ly_content,browseFragment);
                }else{
                    fTransaction.show(browseFragment);
                }
                break;
            case R.id.login:
                if(moreFragment == null){
                    moreFragment = new MoreFragment("登陆");
                    fTransaction.add(R.id.ly_content,moreFragment);
                }else{
                    fTransaction.show(moreFragment);
                }
                break;
        }
        fTransaction.commit();
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(listFragment != null)fragmentTransaction.hide(listFragment);
        if(browseFragment != null)fragmentTransaction.hide(browseFragment);
        if(moreFragment != null)fragmentTransaction.hide(moreFragment);
    }
}
