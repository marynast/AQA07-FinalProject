package models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class AddProjectField {
    private int id;
    private String name;
    private String announcement;
    private int typeOfProject;
    private boolean completed;
    private boolean showAnnouncement;

}
