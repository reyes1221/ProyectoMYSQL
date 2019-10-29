package com.example.proyectoomysql;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MantenimientoMYSQL  {

    boolean estadoGuarda = false;


    public void guardar(final Context context, final String codigo, final String descripcion, final String precio){
        String url = "http://mjql.com.sv/mysql_crud/guardar.php";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject requestJSON = new JSONObject(response.toString());
                    String estado = requestJSON.getString("estado");
                    String mensaje = requestJSON.getString("mensaje");

                    if (estado.equals("1")){
                        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                    }else if (mensaje.equals("2")){
                        Toast.makeText(context, "No se puede guardar .\n"+ "intente mas tarde", Toast.LENGTH_SHORT).show();
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener(){

            @Override

            public void onErrorResponse(VolleyError error){
                Toast.makeText(context, "no se puede guardar. \n" + "Verifique su acceso a internet.", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> map = new HashMap<>();
                map.put("Content-Type", "application/json; charset=utf-8");
                map.put("Accept", "application/json");
                map.put("codigo", codigo);
                map.put("descripcion", descripcion);
                map.put("precio", precio);
                return map;
            }
        };
        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}
