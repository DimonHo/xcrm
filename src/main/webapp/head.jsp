<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
  	<div class="navbar-header">
          <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm" href="#" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'navbar-首页'])"><span class="glyphicon glyphicon-tint"></span>CRM系统</a>
    </div>
    <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="#"  target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'v2doc'])"><span class="glyphicon glyphicon-home"></span>&nbsp;首页</a></li>
            <li><a href="#" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'v3doc'])"><span class="glyphicon glyphicon-time"></span>&nbsp;历史</a></li>
            <li><a href="#" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'v4doc'])"><span class="glyphicon glyphicon-bold"></span>&nbsp;收费</a></li>
            <li><a href="#" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'less'])"><span class="glyphicon glyphicon-globe"></span>&nbsp;资源</a></li>
            <li><a href="#" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'jquery'])"><span class="glyphicon glyphicon-cog"></span>&nbsp;设置</a></li>
          </ul>
          <form class="navbar-form navbar-right" role="search">
		      <div class="form-group">
		        <input type="text" class="form-control" placeholder="Search">
		      </div>
  		  </form>
        </div>
  </div>
  
</nav>