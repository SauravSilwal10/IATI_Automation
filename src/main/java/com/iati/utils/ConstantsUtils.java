package com.iati.utils;
import com.github.javafaker.Faker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConstantsUtils {


    static Faker faker = new Faker();
    static Random random = new Random();
    public static final int waitTime = 5;
    public static final String test = null;


    /*--------------------Nav Bar menu-----------------------------------------------------*/

    public static final int navBarMenuCount=5;
    public static final String IATIHeader="IATI Publisher";
    public static final String languageTitle="LANGUAGE:";
    public static final int languagesCount=3;
    public static final String signInTitle="Sign In.";
    public static final String welcomeText="Welcome back! Please enter your details.";
    public static final String LANGUAGE_SHEET ="activityLanguage" ;
    public static List<String> navBarMenuList() {
        List<String> navBarList = new ArrayList<>();
        navBarList.add("ABOUT");
        navBarList.add("PUBLISHING CHECKLIST");
        navBarList.add("IATI STANDARD");
        navBarList.add("SUPPORT");
        return navBarList;
    }
    public static ArrayList<String> languages() {
        ArrayList<String> languageList = new ArrayList<>();
        languageList.add("EN");
        languageList.add("FR");
        languageList.add("ES");
        return languageList;
    }



    /*--------------------Form Content-----------------------------------------------------*/
    /*====================Login=============================================================*/

    public static final String formHeader = "Sign In.";
    public static final String formDescription = "Welcome back! Please enter your details.";
    public static final String formUsernameLabel = "Username";
    public static final String formPasswordLabel = "Password";
    public static final String formForgotPassword = "Forgot your password? Reset.";
    public static final String formSignIn = "SIGN IN";

    public static final String blankUsername = "The username field is required.";
    public static final String blankPassword = "The password field is required.";
    public static final String wrongCredential = "These credentials do not match our records.";

    /*====================Registration=============================================================*/
    public static final String EXCEL_NAME ="Registration_DataSet" ;

    public static final String containerFooterRegistration = "Haven't registered yet?Join Now";
    public static String joinNowTitle="Join Now.";
    public static String publisherInfoTitle = "Create IATI Publisher Account";


    /*--------------------Footer-----------------------------------------------------*/
    public static String IATIStandardTitle ="IATI Standard";
    public static String IATIPublisherTitle ="IATI Publisher";
    public static final String headerYourActivities = "Your Activities";
    public static String footerSupportEmail="support@iatistandard.org";
    public static String footerCpyRightText="Copyright IATI 2022. All rights reserved.";
    public static ArrayList<String> footerIATIStandard() {
        ArrayList<String> menuList = new ArrayList<>();
        menuList.add("IATI Standard");
        menuList.add("Publishing Checklist");
        menuList.add("Access IATI Data");
        menuList.add("Support");
        return menuList;
    }
    public static ArrayList<String> footerIATIPublisher() {
        ArrayList<String> menuList = new ArrayList<>();
        menuList.add("Home");
        menuList.add("About");
        menuList.add("Sign In");
        menuList.add("Join Now");
        return menuList;
    }
    public static ArrayList<String> footerNotes() {
        ArrayList<String> notes = new ArrayList<>();
        notes.add("Part of the IATI Unified Platform");
        notes.add("Code licensed under the GNU AGPL.");
        notes.add("Documentation licensed under CC BY 3.0");
        return notes;
    }




    /*--------------------Activities-----------------------------------------------------------*/
    public static final String activitiesTitles="Your Activities";
    /*--------------------Activities Popup-----------------------------------------------------*/
    public static String activityPopupTitle="Add a title and identifier for the activity";
    public static String activityIdPrefix = "AE-ACCI-123456789-";
    public static int activityLangCount = 181;
    public static String activityNarrative=faker.chuckNorris().fact();
    public static final String activityID = faker.idNumber().ssnValid();


    public static List<String> addActivitySectionTitle() {
        ArrayList<String> sectionTitle = new ArrayList<>();
        sectionTitle.add("title");
        sectionTitle.add("iati-identifier");
        return sectionTitle;
    }

    public static List<String> addActivityFormTitle() {
        ArrayList<String> formTitle = new ArrayList<>();
        formTitle.add("narrative *");
        formTitle.add("@xml: lang *");
        formTitle.add("activity identifier *");
        formTitle.add("iati-identifier *");
        return formTitle;
    }

    public static List<String> addActivityValidationMsg() {
        ArrayList<String> validationMsg = new ArrayList<>();
        validationMsg.add("The narrative field is required.");
        validationMsg.add("The language field is required.");
        validationMsg.add("The activity identifier field is required.");
        return validationMsg;
    }


    /*--------------------Element-----------------------------------------------------------*/
    /*--------------------Activity Status Element-----------------------------------------------------------*/
    public static String activityStatusCode="@code *";
    public static String activityStatusTitle ="activity-status";
    public  static String activityCoreElements= "Core Elements";
    public static  String activityMandatorySubElements ="Mandatory sub-elements";
    public static  String activityRecommendedSubElements ="Recommended sub-elements";

    public static int activityDropDownTypeCount=6;

    public static ArrayList<String> activityStatusDropDown() {
        ArrayList<String>  dropDownList = new ArrayList<>();
        dropDownList.add("1 - Pipeline/identification");
        dropDownList.add("2 - Implementation");
        dropDownList.add("3 - Finalisation");
        dropDownList.add("4 - Closed");
        dropDownList.add("5 - Cancelled");
        dropDownList.add("6 - Suspended");
        return dropDownList;

    }

    /*-------------------------Activity Scope Element -------------------------------------------------------*/
    public static String activityScopeTitle ="activity-scope";
    public static String activityScopeCode ="@code *";
    public static int activitySCopeDropDownTypeCount=8;
    public static ArrayList<String> activityScopeCodeList() {
        ArrayList<String> codeList = new ArrayList<>();
        codeList.add("1 - Global");
        codeList.add("2 - Regional");
        codeList.add("3 - Multi-national");
        codeList.add("4 - National");
        codeList.add("5 - Sub-national: Multi-first-level administrative areas");
        codeList.add("6 - Sub-national: Single first-level administrative area");
        codeList.add("7 - Sub-national: Single second-level administrative area");
        codeList.add("8 - Single location");
        return codeList;
    }

/*------------------------------Description----------------------------------------------------*/

    public static String descriptionTitle = "description";

    /*--------------------Other Identifier Element-----------------------------------------------------------*/
    public static String otherIdTitle ="other-identifier";
    public static String otherIdentifierRef="@ref *";
    public static String otherIdentifierType="@type *";
    public static String otherIdentifierOwnerOrgLabel ="Owner org";
    public static int otherIdentifierTypeCount=6;


    public static ArrayList<String> otherIdentifierOwnerOrgLabels() {
        ArrayList<String> label = new ArrayList<>();
        label.add("@ref");
        label.add("narrative");
        label.add("@xml:lang");
        return label;
    }

    public static ArrayList<String> otherIdentifierTypeList() {
        ArrayList<String> typeList = new ArrayList<>();
        typeList.add("A1 - Reporting Organisation's internal activity identifier");
        typeList.add("A2 - CRS Activity identifier");
        typeList.add("A3 - Previous Activity Identifier");
        typeList.add("A9 - Other Activity Identifier");
        typeList.add("B1 - Previous Reporting Organisation Identifier");
        typeList.add("B9 - Other Organisation Identifier");
        return typeList;
    }




    public static String otherIdentifierType() {
        int index=random.nextInt(otherIdentifierTypeList().size());
       return otherIdentifierTypeList().get(index);
    }
    /*--------------------Registration-----------------------------------------------------------*/

    public static String registrationFormTitle="Publisher Information";
    public static String invalidPubisherName="The publisher name field is required.";
    public static List<String> registrationStepI() {
        ArrayList<String> validateRegistrationMsg = new ArrayList<>();
        validateRegistrationMsg.add("The publisher name field is required.");
        validateRegistrationMsg.add("The publisher id field is required.");
        validateRegistrationMsg.add("The registration agency field is required.");
        validateRegistrationMsg.add("The registration number field is required.");
        return validateRegistrationMsg;
    }


    /*--------------------Common Nav Bar -----------------------------------------------------------*/

    public static ArrayList<String> pageList() {
        ArrayList<String> pages = new ArrayList<>();
        pages.add("ACTIVITY DATA");
        pages.add("ORGANISATION DATA");
        pages.add("SETTINGS");
        return pages;
    }

    public static ArrayList<String> profileMenu() {
        ArrayList<String> profile = new ArrayList<>();
        profile.add("Publisher Name 3");
        profile.add("Your Profile");
        profile.add("Logout");
        return profile;
    }
}
