public enum option
{
    Admin , Studnet;

    private String value  () {
        return   name();
    }

    public  static option fromvalu ( String  v )
    {

        return valueOf( v);
    }


}
