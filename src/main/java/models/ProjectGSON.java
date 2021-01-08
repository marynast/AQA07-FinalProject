package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectGSON {
    int id;
    String name;
    String announcement;
    boolean show_announcement;
    boolean is_completed;
    String completed_on;
    int suite_mode;
    String url;
}
