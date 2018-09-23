package br.com.example.alalgi.bandodedadossqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //Criando o bando de dados com nome APP privato para que somente nosso app o veja.
            SQLiteDatabase bancoDados = openOrCreateDatabase("App", MODE_PRIVATE , null);

            //Criando tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome  VARCHAR, idade int(3))");

            //Inserindo dados
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Gilmar', 38) ");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Borges', 109) ");

            //Recuperando pessoas
            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas", null);

            
            while(cursor != null){
                Log.i("RESULTADO nome",cursor.getString(0));
             Log.i("RESULTADO idade", cursor.getString(1));

            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
