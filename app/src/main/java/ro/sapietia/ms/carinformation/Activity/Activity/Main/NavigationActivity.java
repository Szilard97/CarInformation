package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import android.content.Context;
import android.content.Intent;

import ro.sapietia.ms.carinformation.Activity.Activity.Login.ConfirmActivity;
import ro.sapietia.ms.carinformation.Activity.Activity.Login.FirstActivity;
import ro.sapietia.ms.carinformation.Activity.Activity.Login.LoginActivity;
import ro.sapietia.ms.carinformation.Activity.Activity.Login.TermsAndConditions;
import ro.sapietia.ms.carinformation.Activity.Activity.Menu.AboutActivity;
import ro.sapietia.ms.carinformation.Activity.Activity.Menu.ProfileActivity;
import ro.sapietia.ms.carinformation.Activity.Activity.Menu.SettingsActivity;

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

    public static void navigateToItemInformation(final Context context) {

        context.startActivity( new Intent(context, ItemInformation.class));
    }

    public static void navigateToLogIn(final Context context) {

        context.startActivity( new Intent(context, LoginActivity.class));
    }

    public static void navigateToConfirm(final Context context) {

        context.startActivity( new Intent(context, ConfirmActivity.class));
    }

    public static void navigateToMain(final Context context) {

        context.startActivity( new Intent(context, MainActivity.class));
    }

    public static void navigateToTermAndConditions(final Context context) {

        context.startActivity( new Intent(context, TermsAndConditions.class));
    }

}
