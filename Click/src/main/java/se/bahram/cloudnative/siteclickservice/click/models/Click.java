package se.bahram.cloudnative.siteclickservice.click.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.Date;

@Data
@Builder
public class Click {

    private String clientCode;

    private String hostUrl;

    private String adCode;

    private Date actualClickTime;
}
