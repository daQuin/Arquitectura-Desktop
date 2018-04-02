package co.edu.ufps.controlador;

import co.edu.ufps.modelo.Mensaje;
import co.edu.ufps.modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import com.google.gson.JsonParser;
import java.util.List;

/**
 *
 * @author Dairo F. Ramirez
 */
public class Conexion {

//    private static String ruta = "http://localhost:1337/";
    private static String ruta = "https://d880ac9b.ngrok.io/";
    public static Usuario Login(String params) {
        Usuario u = null;
        URL url;
        try {
            String rta = "";
            url = new URL(ruta + "usuario?usuario=" + params);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String linea;
            while ((linea = in.readLine()) != null) {
                rta += linea;
            }
            Gson gson = new Gson();
            JsonArray json = (JsonArray) new JsonParser().parse(rta);
            Usuario[] array = gson.fromJson(json, Usuario[].class);
            if (array.length > 0) {
                u = array[0];
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return u;
    }

    public static Usuario registrarUsuario(String data) throws IOException {
        URL url = new URL(ruta + "usuario");
        Map<String, Object> params = new LinkedHashMap<>();

        params.put("usuario", data);

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()),
                    "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length",
                String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), "UTF-8"));
        String rta = "";
        for (int c = in.read(); c != -1; c = in.read()) {
            rta += (char) c;
        }
        System.out.println(rta);
        Gson gson = new Gson();
        JsonObject json = (JsonObject) new JsonParser().parse(rta);
        Usuario u = gson.fromJson(json, Usuario.class);
        return u;
    }

    public static Usuario[] listarUsuarios() {
        URL url;
        try {
            String rta = "";
            url = new URL(ruta + "usuario");
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String linea;
            while ((linea = in.readLine()) != null) {
                rta += linea;
            }
            Gson gson = new Gson();
            JsonArray json = (JsonArray) new JsonParser().parse(rta);
            Usuario[] array = gson.fromJson(json, Usuario[].class);
            return array;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void enviarMensaje(String data, Usuario remitente, Usuario destinatario) throws IOException {
        URL url = new URL(ruta + "mensaje");
        Map<String, Object> params = new LinkedHashMap<>();
//        System.out.println(remitente.getId());
        Gson gson = new Gson();
//        Mensaje mm = new Mensaje(data, remitente, destinatario);
//        String js = gson.toJson(mm);
//        JsonObject js1 = (JsonObject) new JsonParser().parse(js);
        params.put("texto",data);
        params.put("remitente",remitente.getId());
        params.put("destinatario",destinatario.getId());

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()),
                    "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length",
                String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), "UTF-8"));
        String rta = "";
        for (int c = in.read(); c != -1; c = in.read()) {
            rta += (char) c;
        }
//        System.out.println(rta);
//        JsonObject json = (JsonObject) new JsonParser().parse(rta);
//        Mensaje m = gson.fromJson(json, Mensaje.class);
//        System.out.println(m);
//        return m;
    }
    public static Mensaje[] listarMensaje() {
        URL url;
        try {
            String rta = "";
            url = new URL(ruta + "mensaje");
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String linea;
            while ((linea = in.readLine()) != null) {
                rta += linea;
            }
            Gson gson = new Gson();
            JsonArray json = (JsonArray) new JsonParser().parse(rta);
            Mensaje[] array = gson.fromJson(json, Mensaje[].class);
            return array;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
