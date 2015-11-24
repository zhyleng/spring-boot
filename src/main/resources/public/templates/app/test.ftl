<div >
	<#assign xy="xy已导入">
	<div>Number: ${items?size}</div>
	<div>User1: ${items[0]}</div>
</div>
<#macro test title="标题">
	<h2>Macro ${title}</h2>
</#macro>

<#macro wrap count>
	
	<div style="width:100px; height:300px; border:1px red solid;">
		<#local y="test">
		<#list 1..count as i>
			${y}-${i}/${count} <br/> 
		</#list>	
		<#nested>
	</div> 
</#macro>


<#function isEmpty str>
	<#if str?? &&  str?has_content>
		<#return false>
	<#else>
		<#return true>
	</#if>
</#function>

<#-- Freemarker 宏 -->
<#macro repeat count>
	<#list 1..count as x>
		<#nested x, x/2, x_has_next>
	</#list>
</#macro>
