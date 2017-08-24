package lotteryaward.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class GameResult implements Serializable{
	
    private Long id;

    private String gameId;

    private String issue;

    private LocalDateTime createDate;

    private LocalDateTime resultDate;

    private String result;

    private LocalDateTime lastResultDate;

    private String gameName;

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
		this.gameId = gameId;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getResultDate() {
		return resultDate;
	}

	public void setResultDate(LocalDateTime resultDate) {
		this.resultDate = resultDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LocalDateTime getLastResultDate() {
		return lastResultDate;
	}

	public void setLastResultDate(LocalDateTime lastResultDate) {
		this.lastResultDate = lastResultDate;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}


 }