package net.codog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameVideo {
	private String game_video_name;
	private String game_video_link;
	private String game_video_desc;
	private String game_video_picture;
	private String game_video_type_name;
}
