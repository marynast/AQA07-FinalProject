package utils;

public class SQLqueries {

    public String addProjectInformation(int id) {
        return "SELECT * FROM public.projects WHERE id ='"+ id +"'";
    }
}
