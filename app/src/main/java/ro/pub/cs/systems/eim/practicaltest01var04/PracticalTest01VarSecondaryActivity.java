package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01VarSecondaryActivity extends AppCompatActivity {


    private TextView numeFinal;
    private TextView grupaFinal;
    private Button buttonOk;
    private Button buttonCancel;


    private  OKButtonClickListener okButtonClickListener =  new  OKButtonClickListener();
    private class  OKButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            setResult(RESULT_OK, null);
            finish();
        }
    }

    private  CancelButtonClickListener CancelButtonClickListener =  new  CancelButtonClickListener();
    private class  CancelButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            setResult(RESULT_CANCELED, null);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var_secondary);

        // caut buton si setez listener pt el
        buttonOk = (Button)findViewById(R.id.buttonOK);
        buttonOk.setOnClickListener(okButtonClickListener);

        buttonCancel = (Button)findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(CancelButtonClickListener);

        numeFinal = (TextView)findViewById(R.id.textNume);
        grupaFinal = (TextView)findViewById(R.id.textGrupa);

        if(savedInstanceState==null){
            Bundle extras = getIntent().getExtras();
            if(extras==null) {
                numeFinal.setText("");
                grupaFinal.setText("");
            }else{
                numeFinal.setText(extras.getString(Constants.STUDENT_TEXT));
                grupaFinal.setText(extras.getString(Constants.GROUP_TEXT));
                //numberFinal.setText(extras.getString(Constants.LEFT_TEXT) + " " + extras.getString(Constants.RIGHT_TEXT));
            }


        }else{
            numeFinal.setText(savedInstanceState.getString("numeFinal"));
            grupaFinal.setText(savedInstanceState.getString("grupaFinal"));
        }

    }
}