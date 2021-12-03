public class Test {
    public static void main(String[] args) {
        String s1 = "true";
        String s2 = new String("true");
        String s3 = "true";
        System.setProperty(s1, "true");
        System.setProperty(s2, "true");
        System.out.println(Boolean.getBoolean(s1));//true
        System.out.println(Boolean.getBoolean(s2));//true
        System.out.println(Boolean.getBoolean(s3));//false

        System.out.println(Boolean.getBoolean("tt"));
    }
}
