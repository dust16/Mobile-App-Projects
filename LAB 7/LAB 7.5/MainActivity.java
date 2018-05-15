package keymanage.android.lab75_11798_dustin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, button1);
                //inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.popup_menu,popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        Intent i = new Intent();
                        if(item.getTitle().equals("One"))
                        {
                            i = new Intent(MainActivity.this, Activity1.class);
                        }
                        else if(item.getTitle().equals("Two"))
                        {
                            i = new Intent(MainActivity.this,Activity2.class);
                        }
                        else if(item.getTitle().equals("Three"))
                        {
                            i = new Intent(MainActivity.this,Activity3.class);
                        }
                        else return true;

                        Toast.makeText(getApplicationContext(), "You Clicked: "+ item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        return true;
                    }

                });

                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method
    }
}
