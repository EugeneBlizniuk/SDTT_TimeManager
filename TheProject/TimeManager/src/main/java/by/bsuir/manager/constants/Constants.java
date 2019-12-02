package by.bsuir.manager.constants;

public final class Constants {
    private Constants() {}

    public static final String CORRECT_PASSWORD = "password_is_correct";
    public static final String PASSWORD = "password";
    public static final String LOGIN = "login";
    public static final String USER_IS_ADDED = "Added!";
    public static final String WRONG_LOGIN_JS = "<script type='text/javascript'>" +
            "alert('Login is incorrect');location='/home'</script>";
    public static final String WRONG_PASSWORD_JS = "<script type='text/javascript'>" +
            "alert('Password is incorrect');location='/home'</script>";
    public static final String EMPTY_FIELD_JS = "<script type='text/javascript'>" +
            "alert('Fill in ALL the fields!');location='/home'</script>";
    public static final String EMPTY_FIELD_SU_JS = "<script type='text/javascript'>" +
            "alert('Fill in ALL 3 the fields!');location='/sign-up'</script>";
    public static final String PASSWORDS_DO_NOT_MATCH_JS = "<script type='text/javascript'>" +
            "alert('Passwords do not match, try again!');location='/sign-up'</script>";
    public static final String LOGIN_EXISTS_JS = "<script type='text/javascript'>" +
            "alert('Login has already existed, try again!');location='/sign-up'</script>";
}
