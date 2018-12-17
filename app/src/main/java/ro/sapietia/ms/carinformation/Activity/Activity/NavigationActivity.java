package ro.sapietia.ms.carinformation.Activity.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class NavigationActivity {

    public static void navigateToProfile(Context context) {

        context.startActivity(new Intent(context, ProfileActivity.class));
    }

    public static void navigateToSettings(Context context) {

        context.startActivity(new Intent(context, SettingsActivity.class ));
    }

    public static void navigateToAbout(Context context) {

        context.startActivity(new Intent(context, AboutActivity.class ));
    }


    public static void navigateToLogout(final Context context) {

        context.startActivity(new Intent(context, FirstActivity.class ));
    }

    public static void navigateToAddItem(final Context context) {

        context.startActivity( new Intent(context, AddItemActivity.class));
    }


}
