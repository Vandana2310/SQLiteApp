package com.example.sqliteapp58;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText edtComputerName, edtComputerType;
    Button btnAdd, btnDelete;
    ListView listView;

    List<Computer> allComputers;

    ArrayList<String> computersName;

    MySqliteHandler databaseHandler;

    ArrayAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtComputerName = (EditText) findViewById(R.id.edtComputerName);
        edtComputerType = (EditText) findViewById(R.id.edtComputerType);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        listView = (ListView) findViewById(R.id.listView);



        btnAdd.setOnClickListener(MainActivity.this);
        btnDelete.setOnClickListener(MainActivity.this);




        databaseHandler = new MySqliteHandler(MainActivity.this);
        allComputers = databaseHandler.getAllComputers();
        computersName = new ArrayList<>();


        if (allComputers.size() > 0) {

            for (int i = 0; i < allComputers.size(); i++) {

                Computer computer = allComputers.get(i);
                computersName.add(computer.getComputerName() + " - " + computer.getComputerType());

            }
        }


        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, computersName);
        listView.setAdapter(adapter);






    }


    @Override
    public void onClick(View view) {



        switch (view.getId()) {

            case R.id.btnAdd:

                if (edtComputerName.getText().toString().matches("") || edtComputerType.getText().toString().matches("")) {
                    return;
                }
                Computer computer = new Computer(edtComputerName.getText().toString(), edtComputerType.getText().toString());

                allComputers.add(computer);
                databaseHandler.addComputer(computer);
                computersName.add(computer.getComputerName() + " - " + computer.getComputerType());
                edtComputerName.setText("");
                edtComputerType.setText("");

                break;

            case R.id.btnDelete:


                if (allComputers.size() > 0) {
                    computersName.remove(0);
                    databaseHandler.deleteComputer(allComputers.get(0));
                    allComputers.remove(0);
                } else
                    return;

                break;

        }

        adapter.notifyDataSetChanged();

    }
}
