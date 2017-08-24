package lotteryaward.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class Game implements Serializable{
	
    private String id;

    private String name;

    private String type;

    private String gameClassId;

    private BigDecimal isHost;

    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getGameClassId() {
        return gameClassId;
    }

    public void setGameClassId(String gameClassId) {
        this.gameClassId = gameClassId == null ? null : gameClassId.trim();
    }

    public BigDecimal getIsHost() {
        return isHost;
    }

    public void setIsHost(BigDecimal isHost) {
        this.isHost = isHost;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}