package utils;

public class SQLQueries {

    public String addProjectInformation(int id) {
        return "SELECT * FROM public.projects WHERE id ='"+ id +"'";
    }
}
