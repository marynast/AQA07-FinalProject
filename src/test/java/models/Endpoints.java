package models;

public class Endpoints {

        public static String addProject = "index.php?/api/v2/add_project";
        public static String getProjects = "/index.php?/api/v2/get_projects";
        public static String getCurrentsUser = "/index.php?/api/v2/get_current_user";
        public static String getAllActiveProjects = "/index.php?/api/v2/get_projects&is_completed=0";
    }
