package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import android.content.Context;
import android.content.Intent;

import ro.sapietia.ms.carinformation.Activity.Activity.Login.RegistrationActivity;
import ro.sapietia.ms.carinformation.Activity.Activity.Login.FirstActivity;
import ro.sapietia.ms.carinformation.Activity.Activity.Login.LoginActivity;
import ro.sapietia.ms.carinformation.Activity.Activity.Login.TermsAndConditions;
import ro.sapietia.ms.carinformation.Activity.Activity.Menu.AboutActivity;

public class NavigationActivity {



    public static void navigateToAbout(Context context) {

        context.startActivity(new Intent(context, AboutActivity.class ));
    }

    public static void navigateToLogout(final Context context) {

        context.startActivity(new Intent(context, FirstActivity.class ));
    }

    public static void navigateToLogIn(final Context context) {

        context.startActivity( new Intent(context, LoginActivity.class));
    }

    public static void navigateToTermAndConditions(final Context context) {

        context.startActivity( new Intent(context, TermsAndConditions.class));
    }

}
