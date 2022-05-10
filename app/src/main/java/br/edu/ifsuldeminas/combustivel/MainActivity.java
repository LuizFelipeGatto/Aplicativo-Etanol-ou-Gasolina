package br.edu.ifsuldeminas.combustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInputEditTextEthanol;
    private TextInputEditText textInputEditTextGas;
    private Button buttonCalculate;
    private ImageView imageViewResult;
    private ImageView imageViewShare;
    private TextView textViewTip;
    private Double ethanolValue, gasValue;
    private String betterOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputEditTextEthanol = findViewById(R.id.imputEditTextEthanolValueId);
        textInputEditTextGas = findViewById(R.id.imputEditTextGasValueId);
        buttonCalculate = findViewById(R.id.buttonCalculateId);
        imageViewResult = findViewById(R.id.imageView2);
        imageViewShare = findViewById(R.id.imageView3);
        textViewTip = findViewById(R.id.textView3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        imageViewResult.setVisibility(ImageView.INVISIBLE);
        imageViewShare.setVisibility(ImageView.INVISIBLE);
        textViewTip.setVisibility(TextView.INVISIBLE);
    }

    public void buttonCalculateClick(View view){
        String ethanolStringValue = textInputEditTextEthanol.getText().toString();
        String gasStringValue = textInputEditTextGas.getText().toString();

        if(ethanolStringValue.equals("")){
            Toast t = Toast.makeText(getApplicationContext(), getString(R.string.input_edit_text_ethanol_hint), Toast.LENGTH_SHORT);
            t.show();
            return;
        }

        if(gasStringValue.equals("")){
            Toast.makeText(getApplicationContext(), getString(R.string.input_edit_text_gas_hint), Toast.LENGTH_SHORT).show();
            return;
        }

        ethanolValue = Double.parseDouble(ethanolStringValue);
        gasValue = Double.parseDouble(gasStringValue);

        if((ethanolValue / gasValue) < 0.7){
            imageViewResult.setImageResource(R.drawable.ethanol);
            betterOption = getString(R.string.better_option_ethanol);
        }else{
            imageViewResult.setImageResource(R.drawable.gas);
            betterOption = getString(R.string.better_option_gas);
        }

        imageViewResult.setVisibility(View.VISIBLE);
        imageViewShare.setVisibility(View.VISIBLE);
        textViewTip.setText(betterOption);
        textViewTip.setVisibility(View.VISIBLE);
    }
}