package com.stefangansevles.foodbook.fragments;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.stefangansevles.foodbook.adapters.ImageSpinnerAdapter;
import com.stefangansevles.foodbook.model.Countries;
import com.stefangansevles.foodbook.model.FoodTypes;
import com.stefangansevles.foodbook.model.Kitchenware;
import com.stefangansevles.foodbook.model.SpinnerImage;
import com.stefangansevles.foodbook.R;

import java.util.ArrayList;


public class CreateFragment extends Fragment
{

    ArrayList<SpinnerImage> foodSpinnerItems = new ArrayList<>();
    ArrayList<SpinnerImage> countrySpinnerItems = new ArrayList<>();

    ImageSpinnerAdapter adapterFood;
    ImageSpinnerAdapter adapterCountry;

    Spinner spinnerFood;
    Spinner spinnerCountry;

    EditText tbIngredients;
    EditText tbFoodName;

    //Kitchen Equipment checkboxes
    CheckBox cbOven;
    CheckBox cbPot;
    CheckBox cbPan;
    CheckBox cbFryer;
    CheckBox cbMicrowave;
    CheckBox cbMixer;
    CheckBox cbBlender;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_create,container,false);

        spinnerFood = root.findViewById(R.id.spinnerFood);
        spinnerCountry = root.findViewById(R.id.spinnerCountry);
        tbIngredients = root.findViewById(R.id.tbIngredients);
        tbFoodName = root.findViewById(R.id.tbFoodName);

        cbOven = root.findViewById(R.id.cbOven);
        cbPot = root.findViewById(R.id.cbPot);
        cbPan = root.findViewById(R.id.cbPan);
        cbFryer = root.findViewById(R.id.cbFryer);
        cbMicrowave = root.findViewById(R.id.cbMicrowave);
        cbMixer = root.findViewById(R.id.cbMixer);
        cbBlender = root.findViewById(R.id.cbBlender);


        //Fill the spinners with food and country items
        fillSpinners();

        adapterCountry = new ImageSpinnerAdapter(getContext(), R.layout.spinner_image_record, countrySpinnerItems);

        adapterFood  = new ImageSpinnerAdapter(getContext(), R.layout.spinner_image_record, foodSpinnerItems);

        spinnerFood.setAdapter(adapterFood);
        spinnerCountry.setAdapter(adapterCountry);

        //Set the default selected item to "Other"
        spinnerFood.setSelection(spinnerFood.getAdapter().getCount()-1);
        spinnerCountry.setSelection(spinnerCountry.getAdapter().getCount()-1);

        return root;
    }

    /**
     * Fills the spinners with data
     */
    private void fillSpinners() {

        foodSpinnerItems.clear();
        countrySpinnerItems.clear();
        for (FoodTypes itm : FoodTypes.values())
        {
            switch (itm)
            {
                case PASTA: foodSpinnerItems.add(new SpinnerImage(R.drawable.pasta,getResources().getString(R.string.pasta),FoodTypes.PASTA));
                    break;
                case POTATO_BASE: foodSpinnerItems.add(new SpinnerImage(R.drawable.potato,getResources().getString(R.string.potato),FoodTypes.POTATO_BASE));
                    break;
                case CORN_BASE: foodSpinnerItems.add(new SpinnerImage(R.drawable.corn,getResources().getString(R.string.corn),FoodTypes.CORN_BASE));
                    break;
                case RICE_BASE: foodSpinnerItems.add(new SpinnerImage(R.drawable.rice,getResources().getString(R.string.rice),FoodTypes.RICE_BASE));
                    break;
                case VEGETABLE_BASE: foodSpinnerItems.add(new SpinnerImage(R.drawable.broccoli,getResources().getString(R.string.vegetable),FoodTypes.VEGETABLE_BASE));
                    break;
                case FISH: foodSpinnerItems.add(new SpinnerImage(R.drawable.fish,getResources().getString(R.string.seafood),FoodTypes.FISH));
                    break;
                case PIZZA: foodSpinnerItems.add(new SpinnerImage(R.drawable.pizza,getResources().getString(R.string.pizza),FoodTypes.PIZZA));
                    break;
                case SOUP: foodSpinnerItems.add(new SpinnerImage(R.drawable.bowl_gray,getResources().getString(R.string.soup),FoodTypes.SOUP));
                    break;
                case DRINK: foodSpinnerItems.add(new SpinnerImage(R.drawable.drink,getResources().getString(R.string.drink),FoodTypes.DRINK));
                    break;
                case VEGAN: foodSpinnerItems.add(new SpinnerImage(R.drawable.vegan,getResources().getString(R.string.vegan),FoodTypes.VEGAN));
                    break;
                case SNACK: foodSpinnerItems.add(new SpinnerImage(R.drawable.nacho,getResources().getString(R.string.snack),FoodTypes.SNACK));
                    break;
                case CAKE_PIE: foodSpinnerItems.add(new SpinnerImage(R.drawable.cake,getResources().getString(R.string.cake),FoodTypes.CAKE_PIE));
                    break;
                case BURGERS: foodSpinnerItems.add(new SpinnerImage(R.drawable.hamburger,getResources().getString(R.string.burger),FoodTypes.BURGERS));
                    break;
                case DESSERT: foodSpinnerItems.add(new SpinnerImage(R.drawable.icecream,getResources().getString(R.string.desserts),FoodTypes.DESSERT));
                    break;
                case OTHER: foodSpinnerItems.add(new SpinnerImage(R.drawable.help,getResources().getString(R.string.other),FoodTypes.OTHER));
                    break;
            }
        }
        for (Countries itm : Countries.values())
        {
            switch (itm)
            {
                case DUTCH: countrySpinnerItems.add(new SpinnerImage(R.drawable.netherlands,getResources().getString(R.string.dutch),Countries.DUTCH));
                    break;
                case BELGIAN: countrySpinnerItems.add(new SpinnerImage(R.drawable.belgium,getResources().getString(R.string.belgium),Countries.BELGIAN));
                    break;
                case MEXICAN: countrySpinnerItems.add(new SpinnerImage(R.drawable.mexico,getResources().getString(R.string.mexican),Countries.MEXICAN));
                    break;
                case ITALIAN: countrySpinnerItems.add(new SpinnerImage(R.drawable.italy,getResources().getString(R.string.italian),Countries.ITALIAN));
                    break;
                case ENGLISH: countrySpinnerItems.add(new SpinnerImage(R.drawable.uk,getResources().getString(R.string.uk),Countries.ENGLISH));
                    break;
                case AMERICAN: countrySpinnerItems.add(new SpinnerImage(R.drawable.usa,getResources().getString(R.string.usa),Countries.AMERICAN));
                    break;
                case FRANCE: countrySpinnerItems.add(new SpinnerImage(R.drawable.france,getResources().getString(R.string.france),Countries.FRANCE));
                    break;
                case SWEDEN: countrySpinnerItems.add(new SpinnerImage(R.drawable.sweden,getResources().getString(R.string.sweden),Countries.SWEDEN));
                    break;
                case CHINESE: countrySpinnerItems.add(new SpinnerImage(R.drawable.china,getResources().getString(R.string.chinese),Countries.CHINESE));
                    break;
                case JAPANESE: countrySpinnerItems.add(new SpinnerImage(R.drawable.japan,getResources().getString(R.string.japanese),Countries.JAPANESE));
                    break;
                case INDIAN: countrySpinnerItems.add(new SpinnerImage(R.drawable.india,getResources().getString(R.string.indian),Countries.INDIAN));
                    break;
                case INDONESIAN: countrySpinnerItems.add(new SpinnerImage(R.drawable.indonesia,getResources().getString(R.string.indonesia),Countries.INDONESIAN));
                    break;
                case SPANISH: countrySpinnerItems.add(new SpinnerImage(R.drawable.spain,getResources().getString(R.string.spain),Countries.SPANISH));
                    break;
                case THAI: countrySpinnerItems.add(new SpinnerImage(R.drawable.thailand,getResources().getString(R.string.thai),Countries.THAI));
                    break;
                case CANADIAN: countrySpinnerItems.add(new SpinnerImage(R.drawable.canada,getResources().getString(R.string.canada),Countries.CANADIAN));
                    break;
                case GREEK: countrySpinnerItems.add(new SpinnerImage(R.drawable.greece,getResources().getString(R.string.greek),Countries.GREEK));
                    break;
                case TURKISH: countrySpinnerItems.add(new SpinnerImage(R.drawable.turkey,getResources().getString(R.string.turkish),Countries.TURKISH));
                    break;

                case OTHER: countrySpinnerItems.add(new SpinnerImage(R.drawable.help,getResources().getString(R.string.other),Countries.OTHER));
                    break;
            }
        }
    }

    public String getIngredients()
    {
        return tbIngredients.getText().toString();
    }
    public String getRecipeName()
    {
        return tbFoodName.getText().toString();
    }
    public ArrayList<Kitchenware> getKitchenRequirements()
    {
        ArrayList<Kitchenware> kitchenRequirements = new ArrayList<>();

        if(cbOven.isChecked())
            kitchenRequirements.add(Kitchenware.OVEN);
        if(cbPot.isChecked())
            kitchenRequirements.add(Kitchenware.POT);
        if(cbPan.isChecked())
            kitchenRequirements.add(Kitchenware.PAN);
        if(cbFryer.isChecked())
            kitchenRequirements.add(Kitchenware.FRYER);
        if(cbMicrowave.isChecked())
            kitchenRequirements.add(Kitchenware.MICROWAVE);
        if(cbMixer.isChecked())
            kitchenRequirements.add(Kitchenware.MIXER);
        if(cbBlender.isChecked())
            kitchenRequirements.add(Kitchenware.BLENDER);

        return kitchenRequirements;
    }
    public Countries getCountry()
    {
        return ((SpinnerImage) spinnerCountry.getSelectedItem()).getCountry();
    }
    public FoodTypes getFoodType()
    {
        return ((SpinnerImage) spinnerFood.getSelectedItem()).getFoodType();
    }


}
