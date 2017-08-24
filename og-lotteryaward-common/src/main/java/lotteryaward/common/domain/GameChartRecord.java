package lotteryaward.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class GameChartRecord implements Serializable{
	
    private Long id;

    private String gameId;

    private String gameName;

    private String playId;

    private String issue;

    private String result;

    private String chartRecord;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId == null ? null : gameId.trim();
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId == null ? null : playId.trim();
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue == null ? null : issue.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getChartRecord() {
        return chartRecord;
    }

    public void setChartRecord(String chartRecord) {
        this.chartRecord = chartRecord == null ? null : chartRecord.trim();
    }

	public LocalDateTime getCreateDate() {
        return createDate;
    }

	public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

	public LocalDateTime getUpdateDate() {
        return updateDate;
    }

	public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

   
}