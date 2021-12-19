package se.bahram.cloudnative.siteclickservice.click.models;

import lombok.*;
import org.springframework.lang.NonNull;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Click {

    private String clientCode;

    private String hostUrl;

    private String adCode;

    private Date actualClickTime;
}
