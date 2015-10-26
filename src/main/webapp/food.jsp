<!--
用两个空格来代替制表符（tab） -- 这是唯一能保证在所有环境下获得一致展现的方法。
嵌套元素应当缩进一次（即两个空格）。
对于属性的定义，确保全部使用双引号，绝不要使用单引号。
不要在自闭合（self-closing）元素的尾部添加斜线 -- HTML5 规范中明确说明这是可选的。
不要省略可选的结束标签（closing tag）（例如，</li> 或 </body>）。
IE 支持通过特定的 <meta> 标签来确定绘制当前页面所应该采用的 IE 版本。除非有强烈的特殊需求，否则最好是设置为 edge mode，从而通知 IE 采用其所支持的最新的模式。
通过明确声明字符编码，能够确保浏览器快速并容易的判断页面内容的渲染方式。这样做的好处是，可以避免在 HTML 中使用字符实体标记（character entity），从而全部与文档编码一致（一般采用 UTF-8 编码）
根据 HTML5 规范，在引入 CSS 和 JavaScript 文件时一般不需要指定 type 属性，因为 text/css 和 text/javascript 分别是它们的默认值。
属性顺序:
HTML 属性应当按照以下给出的顺序依次排列，确保代码的易读性。
class
id, name
data-*
src, for, type, href
title, alt
aria-*, role
class 用于标识高度可复用组件，因此应该排在首位。id 用于标识具体组件，应当谨慎使用（例如，页面内的书签），因此排在第二位。
元素的布尔型属性如果有值，就是 true，如果没有值，就是 false。
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <title>Document</title>
  
  <link rel="stylesheet" href="code-guide.css">
  <script src="code-guide.js"></script>
</head>
<body>
  
</body>
</html>