package keymanage.android.lab72_11798_dustin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final int MENU_NEW_GAME=Menu.FIRST;
    private static final int MENU_QUIT = Menu.FIRST +1;

    /*called when the activity is first created*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*creates the menu items*/
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    /*Handles item selections*/
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case MENU_NEW_GAME:
                newGame();
                return true;
            case MENU_QUIT:
                quit();
                return true;
        }
        return false;
    }
    private void newGame(){
        int a;
    }
    private void quit(){
        int a;
    }
}
