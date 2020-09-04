package com.myapp.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddTask extends AppCompatActivity {
    EditText id,title,description,tag;
    TextView P_id;
    RadioButton L_rbtn,M_rbtn,H_rbtn;
    Button add_btn;
    RadioGroup rg;
String priority= "low";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        id = findViewById(R.id.id);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        tag = findViewById(R.id.tag);
        P_id = findViewById(R.id.P_id);
        L_rbtn = findViewById(R.id.L_rbtn);
        M_rbtn = findViewById(R.id.M_rbtn);
        H_rbtn = findViewById(R.id.H_rbtn);
        add_btn = findViewById(R.id.add_btn);

        rg = findViewById(R.id.rg);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                //for volly
                RequestQueue mRequestQueue;
                StringRequest mStringRequest;
                String url = "https://shubhamandroid1.000webhostapp.com/todoinsert.php";
                //RequestQueue initialized
                mRequestQueue = Volley.newRequestQueue(view.getContext());

                //String Request initialized
                mStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.i("TAG","Error :" + error.toString());
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("id",id.getText().toString());
                        params.put("title",title.getText().toString());
                        params.put("description",description.getText().toString());
                        params.put("priority",priority);
                        params.put("tag",tag.getText().toString());
                        return  params;
                    }
                };

                mRequestQueue.add(mStringRequest);
            }

        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.L_rbtn:
                        priority="low";
                        break;
                    case R.id.M_rbtn:
                        priority="medium";
                        break;
                    case R.id.H_rbtn:
                        priority="high";
                        break;
                }
            }

        });


    }
}