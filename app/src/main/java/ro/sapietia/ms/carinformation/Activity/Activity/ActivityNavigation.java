package ro.sapietia.ms.carinformation.Activity.Activity;

import android.content.Context;
import android.content.Intent;

public class ActivityNavigation {

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
}
