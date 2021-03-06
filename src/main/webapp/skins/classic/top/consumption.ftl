<#include "macro-top.ftl">
<@top "consumption">
<div class="content content-reset">
   <h2><span class="ft-green">♥</span> ${consumptionLabel}${rankingLabel}</h2>
</div>
<div class="list top">
    <ul>
        <#list topConsumptionUsers as user>
        <li>
            <div class="fn-flex">
                <a rel="nofollow"
                   href="${servePath}/member/${user.userName}" 
                   title="${user.userName}"><div class="avatar" style="background-image:url('${user.userAvatarURL}?imageView2/1/w/64/h/64/interlace/0/q/80')"></div></a>
                <div class="has-view fn-flex-1">
                    <h2>
                        ${user_index + 1}.
                        <a rel="bookmark" href="${servePath}/member/${user.userName}">${user.userName}</a>
                    </h2>
                    <div class="ft-gray">
                        <#if user.userIntro!="">
                        <div>
                            ${user.userIntro}
                        </div>
                        </#if>
                        <#if user.userURL!="">
                        <div>
                            <a target="_blank" rel="friend" href="${user.userURL?html}">${user.userURL?html}</a>
                        </div>
                        </#if>
                        <div>
                            ${symphonyLabel} ${user.userNo?c} ${numVIPLabel},
                            <#if 0 == user.userAppRole>${hackerLabel}<#else>${painterLabel}</#if>
                        </div>
                    </div>
                    <div class="cmts" title="${user.userUsedPoint?c}">
                        <a href="${servePath}/member/${user.userName}/points">
                            ${user.userUsedPoint?c}
                        </a>
                        ~ ${yuanLabel}${user.money}
                    </div>
                </div>
            </div>
        </li>
        </#list>
    </ul>
    <br/>
</div>
</@top>