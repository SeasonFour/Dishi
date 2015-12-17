package com.apps.dishi.data;

import android.app.Application;
import android.graphics.Typeface;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by djmosi on 12/10/15.
 */

public class App extends Application {

//    Custom TextType
    private static final String CANARO_EXTRA_BOLD_PATH = "fonts/canaro_extra_bold.otf";
    public static Typeface canaroExtraBold;

    @Override
    public void onCreate() {
        super.onCreate();
        initTypeface();

        // PARSE STUFF

		 /* In this tutorial, we'll subclass ParseObject for convenience to
		 * create and modify Meal objects
		 */
        ParseObject.registerSubclass(Meal.class);

		/*
		 * Fill in this section with your Parse credentials
		 */


        Parse.initialize(this, "WxujS9RrPupa3pwCrM3CuV3N2wVFGQqKK11JxFSD", "71ztokocp0R578T2NmmfjlGDlLkMvT6KQqb9Xvhi");
        //        Parse.enableLocalDatastore(this);
		/*
		 * This app lets an anonymous user create and save photos of meals
		 * they've eaten. An anonymous user is a user that can be created
		 * without a username and password but still has all of the same
		 * capabilities as any other ParseUser.
		 *
		 * After logging out, an anonymous user is abandoned, and its data is no
		 * longer accessible. In your own app, you can convert anonymous users
		 * to regular users so that data persists.
		 *
		 * Learn more about the ParseUser class:
		 * https://www.parse.com/docs/android_guide#users
		 */
        ParseUser.enableAutomaticUser();

		/*
		 * For more information on app security and Parse ACL:
		 * https://www.parse.com/docs/android_guide#security-recommendations
		 */
        ParseACL defaultACL = new ParseACL();

		/*
		 * If you would like all objects to be private by default, remove this
		 * line
		 */
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

    }

    private void initTypeface() {
        canaroExtraBold = Typeface.createFromAsset(getAssets(), CANARO_EXTRA_BOLD_PATH);

    }

}
