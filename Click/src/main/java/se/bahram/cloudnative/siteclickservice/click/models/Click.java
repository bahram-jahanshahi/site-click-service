package se.bahram.cloudnative.siteclickservice.click.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.Date;

@Data
@Builder
public class Click {
    @NonNull
    private String clientCode;
    @NonNull
    private String hostUrl;
    @NonNull
    private String adCode;
    @NonNull
    private Date actualClickTime;
}
