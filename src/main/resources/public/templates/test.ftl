<!doctype html>
<html lang="en">
<head>
	<title>Freemarker</title>
</hedd>

<style>
	#div-center {
		position: fixed;
		left: 100px;
		top: 100px;
	}
</style>
<body>
	<div id="div-center">
		<div>Number: ${items?size}</div>
		<div>User1: ${items[0]}</div>
		<ul>
			<#list items?sort_by("name") as item>
			<li>${item_index+1}: ${item.name+" suffix"}<#if !item_has_next>,</#if></li>
			</#list>
		</ul>
		<#if map?exists>
			<#list map?keys as key>
				<span>Key:${key}</span>
				<span>Value:${map[key].name}</span>
				<br/>
			</#list>
		</#if>
		
		<#assign map = {"语文":90.0, "数学":80, "Java":90} />
		${map.语文}
		
		<br/>
		<#if test?? > 
			null ??
		</#if>
		<#if t?? > 
			" " ??
		</#if>
		<#if s?? > 
			"" ??
		</#if>
		<#assign x = 43 />
		<!-- 为标签内所有的表达式都替换成 x+“suffix”-->
		<#escape x as x+"suffix">
			${x}
			${x?string.percent}	
			
			${r"\\"?html}	
			<br/>
			<#noescape><!-- 排除替换 -->
				${false?string("正确", "错误")}
			</#noescape>
			
			<#assign y = 12.3 />
			#{y;m2M2} <#-- m2:最少两位小数， M2最多两位小数 -->
		</#escape>
		<#-- 字符串前加r 将不转义此字符串 -->
		${r"${y}"}<#-- 本来${"${y}"} 输出是12.3 但是加了r就原值输出了 ${y}-->
		
		${"first"?cap_first}
		${"first"?lower_case}
		${"first"?replace("[fi]{2,}", "F")}
		${dfkadfla!"ceshi"}
	</div>
	<#-- 导入ftl模板文件 -->
	<#include "app/test.ftl">
	<#-- 导入ftl模板文件中的变量、宏等，并将此模板文件的命名空间设为test， 此模板文件中的变量通过test.来访问， import并不会对导入模板文件中的内容进行渲染
	-->
	<#import "/app/test.ftl" as test>
	${test.xy!"xy么导入"}
	
	<#-- 8 +8 8.00都是相等的-->
	${(8=8.00)?string("true", "false")}
	<#assign listlist = [1..5]>
	<#list listlist as iii>
		<div>${iii_has_next?string("true", "false")}</div>
	</#list>
	<#noparse> 
		<#list books as book> 
   		<tr><td>${book.name}<td>作者:${book.author} 
		</#list> 
	</#noparse> 
</body>
</html>
	