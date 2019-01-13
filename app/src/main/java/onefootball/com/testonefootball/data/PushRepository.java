package onefootball.com.testonefootball.data;

import onefootball.com.testonefootball.data.models.PushItem;

public interface PushRepository
{
    void setTeamPush(long teamId, String name, int pushOptions);

    PushItem getTeamPush(long teamId);
}
