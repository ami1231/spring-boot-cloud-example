package lotteryaward.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class GameChartType implements Serializable{

	private Long id;

    private String name;

    private String gameClassId;

    private String chartCode;

    private LocalDateTime createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGameClassId() {
        return gameClassId;
    }

    public void setGameClassId(String gameClassId) {
        this.gameClassId = gameClassId == null ? null : gameClassId.trim();
    }

    public String getChartCode() {
        return chartCode;
    }

    public void setChartCode(String chartCode) {
        this.chartCode = chartCode == null ? null : chartCode.trim();
    }

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

}