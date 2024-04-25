<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
@font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}

* {
	font-family: 'Pretendard-Regular';
}

	.top {
		background-color: #349525;
		height: 5%;
		text-align: right;
	}
	.top a {
		text-decoration: none;
		color: #ffffff;
		margin-right: 30px;
	}
	.nav {
	 	display: flex;
	 	item-align: center;
	 	border-style: none none solid none;
	 	border-color: #ccc;
	 	justify-content: space-between;
	 	line-height: 30px;
	}
	
	.logo {
		font-weight: 600;
		font-size: 1.5rem;
		margin-top: 10px;
		margin-left: 20px;

	}
	
	.logo img {
		height: 30px;
	}
	
	/* The navbar container */
	.topnav {
	  overflow: hidden;
	  background-color: #fff;
	}
	
	/* Navbar links */
	.topnav a {
	  float: left;
	  display: block;
	  color: black;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	  margin-left: 10px;
	  margin-right: 20px;
	}
	
	/* Links - change color on hover */
	.topnav a:hover {
	  color: #349525;
	}
	
		/* The sidebar menu */
	.sidenav {
	  height: 80%; /* Full-height: remove this if you want "auto" height */
	  width: 160px; /* Set the width of the sidebar */
	  position: fixed; /* Fixed Sidebar (stay in place on scroll) */
	  z-index: 1; /* Stay on top */
	  bottom: 0; /* Stay at the top */
	  left: 7%;
	  overflow-x: hidden; /* Disable horizontal scroll */
	  padding-top: 20px;
	}
	
	/* The navigation menu links */
	.sidenav a {
	  padding: 6px 8px 6px 16px;
	  text-decoration: none;
	  font-size: 1.5rem;
	  color: #000;
	  display: block;
	}
	
	.sidenav a:hover {
	  color:  #349525;
	}
	
	.maintop {
		margin-left: 160px;
		margin-top: 70px;
		margin-bottom: 20px;
		border-style: none none solid none;
		border-color: #349525;
		font-size: 2.5rem;
		
	}
	
	.mid {
		width: 80%;
		margin: 0 auto;
		}
	
	/* Style page content */
	.main {
	  margin-left: 160px; /* Same as the width of the sidebar */
	  padding: 0px 10px;
	}
</style>