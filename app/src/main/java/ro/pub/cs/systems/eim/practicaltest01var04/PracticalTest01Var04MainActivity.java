package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {
    Button navigate = null;
    Button display = null;

    EditText name = null;
    EditText group = null;
    CheckBox nameCheck = null;
    CheckBox grupaCheck= null;

    private TextView stringFinal = null;
    String nameStud;
    String groupStud;

    String info;

    private RegisterButtonClickListener registerButtonClickListener = new RegisterButtonClickListener();

    private class RegisterButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
             info = new String();
             nameStud = name.getText().toString();
             groupStud = group.getText().toString();

            if (nameCheck.isChecked()) {
                if (nameStud.isEmpty()) {
                    Toast.makeText(getApplication(), "No student name", Toast.LENGTH_LONG).show();
                } else {
                    info += nameStud;
                }
            }

            if(grupaCheck.isChecked()) {
                if (groupStud.isEmpty()) {
                    Toast.makeText(getApplication(), "No group", Toast.LENGTH_LONG).show();
                } else {
                    info += " " + groupStud;
                }
            }

            stringFinal.setText(info);



        }
    }

    private RegisterButtonClickListenerNavigate registerButtonClickListenerNavigate= new RegisterButtonClickListenerNavigate();

    private class RegisterButtonClickListenerNavigate implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (!nameStud.isEmpty() && !groupStud.isEmpty()) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01VarSecondaryActivity.class);
                intent.putExtra(Constants.STUDENT_TEXT, nameStud);
                intent.putExtra(Constants.GROUP_TEXT, groupStud);
                startActivityForResult(intent,  Constants.RequestCode);
            } else {
                Toast.makeText(getApplication(), "No student name or group", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        navigate = (Button) findViewById(R.id.navigate);
        display = (Button) findViewById(R.id.display);
        name = (EditText) findViewById(R.id.editTextTextPersonName);
        group = (EditText) findViewById(R.id.editTextTextPersonName2);

        nameCheck = (CheckBox) findViewById(R.id.checkBox);
        grupaCheck = (CheckBox) findViewById(R.id.checkBox2);

        stringFinal = (TextView) findViewById(R.id.finalStr);
        display.setOnClickListener(registerButtonClickListener);
        navigate.setOnClickListener(registerButtonClickListenerNavigate);


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString(Constants.STUDENT_TEXT, name.getText().toString());
        savedInstanceState.putString(Constants.GROUP_TEXT, group.getText().toString());
        savedInstanceState.putString(Constants.INFO, stringFinal.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey(Constants.STUDENT_TEXT)) {
            name.setText(savedInstanceState.getString(Constants.STUDENT_TEXT));
        } else {
            name.setText("");
        }

        if (savedInstanceState.containsKey(Constants.GROUP_TEXT)) {
            group.setText(savedInstanceState.getString(Constants.GROUP_TEXT));
        } else {
            group.setText("");
        }

        if (savedInstanceState.containsKey(Constants.INFO)) {
            stringFinal.setText(savedInstanceState.getString(Constants.INFO));
        } else {
            stringFinal.setText("");
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == Constants.RequestCode)
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "The activity returned with result OK", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "The activity returned with result CANCEL", Toast.LENGTH_LONG).show();
            }

    }


}