package lotteryaward.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class GameIssue implements Serializable{

	private Long id;

    private String gameId;

    private String issue;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime awardTime;

    private String fullIssue;

    private String gameClassId;

    private LocalDateTime issueDate;

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

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public LocalDateTime getAwardTime() {
		return awardTime;
	}

	public void setAwardTime(LocalDateTime awardTime) {
		this.awardTime = awardTime;
	}

	public String getFullIssue() {
		return fullIssue;
	}

	public void setFullIssue(String fullIssue) {
		this.fullIssue = fullIssue;
	}

	public String getGameClassId() {
		return gameClassId;
	}

	public void setGameClassId(String gameClassId) {
		this.gameClassId = gameClassId;
	}

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

}