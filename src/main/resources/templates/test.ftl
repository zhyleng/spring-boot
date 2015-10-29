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
	</div>
</body>
</html>
