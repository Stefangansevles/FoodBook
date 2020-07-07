package com.stefangansevles.foodbook.activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.stefangansevles.foodbook.adapters.ImageSpinnerAdapter;
import com.stefangansevles.foodbook.fragments.CreateFragment;
import com.stefangansevles.foodbook.model.Countries;
import com.stefangansevles.foodbook.model.FoodTypes;

import com.stefangansevles.foodbook.R;
import com.stefangansevles.foodbook.model.Kitchenware;
import com.stefangansevles.foodbook.model.SpinnerImage;

import java.util.ArrayList;
import java.util.List;

public class CreateRecipeActivity extends AppCompatActivity implements View.OnClickListener {

    CreateFragment createFragment;
    //InstructionFragment instructionFragment = null;
    //FinishFragment finishFragment;

    Button btnNext;

    //The complete recipe that the user is building
    //Recipe recipe = null;

    //Contains all the added fragments
    List<Fragment> addedFragments = new ArrayList<>();

    List<Kitchenware> kitchenRequirements;
    //Indicates what fragment we're currently at
    int currentFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);

        createFragment = new CreateFragment();


        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);


        //Initially, the createFragment is added.
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentPlaceholder, createFragment, "createFragment").commit();
        addedFragments.add(createFragment);
    }

    @Override
    public void onClick(View view) {

    }
}
