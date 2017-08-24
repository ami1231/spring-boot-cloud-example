package lotteryaward.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class GameChartTask implements Serializable{
	
    private Long id;

    private String gameId;

    private String issue;

    private String result;

    private Long status;

    private Long retryTimes;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private LocalDateTime resultDate;

    private Boolean isFirstIssue;
    
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

	public Boolean getIsFirstIssue() {
		return isFirstIssue;
	}

	public void setIsFirstIssue(Boolean isFirstIssue) {
		this.isFirstIssue = isFirstIssue;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(Long retryTimes) {
		this.retryTimes = retryTimes;
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

	public LocalDateTime getResultDate() {
		return resultDate;
	}

	public void setResultDate(LocalDateTime resultDate) {
		this.resultDate = resultDate;
	}
}