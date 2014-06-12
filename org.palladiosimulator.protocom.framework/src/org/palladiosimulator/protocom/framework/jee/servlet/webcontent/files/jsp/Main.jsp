<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page import="java.util.LinkedList"%>
<%@page language="java" pageEncoding="UTF-8"%>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>ProtoCom</title>
		
		<script type="text/javascript" src="${root}/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="${root}/js/underscore-1.6.0.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="${root}/css/style.css">
		
		<script id="template-module" type="text/template">
			<tr data-id="{{- id }}" data-permanent="{{- permanent }}" data-started="false">
				<td>{{- name }}</td>
				<td class="state"></td>
				<td>
					<button class="action start">Start</button>
					<button class="action stop disabled">Stop</button>
				</td>
			</tr>
		</script>
		
		<script type="text/javascript">
			_.templateSettings = {
				interpolate: /\{\{(.+?)\}\}/g, 
				escape: /\{\{-(.+?)\}\}/g
			};
			
			function finishBox() {
				if (typeof this.count == 'undefined') {
					this.count = 0;
				}
				
				this.count++;
				
				if (this.count == 2) {
					$('#main').show();
				}
			}
			
			function updateModule(id, started) {
				var row = $('[data-id="' + id + '"]');
				var permanent = row.data('permanent');
				
				if (permanent) {
					if (started) {
						row.find('.state').addClass('started').text('Started');	
						row.find('.start').hide();
						row.find('.stop').show();
					} else {
						row.find('.state').removeClass('started').text('Stopped');
						row.find('.start').show();
						row.find('.stop').hide();
					}
				} else {
					row.find('.state').text('');
					row.find('.start').show();
					row.find('.stop').hide();
				}
				
				row.data('started', started);
			}
			
			function updateLog() {
				if (typeof this.logLines == 'undefined') {
					this.logLines = 0;
				}
				
				$.get('${root}', {'action': 'getLog', 'base': logLines}, function(response) {
					var data = response.payload;
					
					if (data.messageCount > 0) {
						var messages = $('#log #messages');
						
						for (var i = 0; i < data.messageCount; i++) {
							if (logLines > 0) messages.append('\n');
							logLines++;
							
							messages.append(data.messages[i]);
						}
						
						messages.scrollTop(messages[0].scrollHeight - messages.height());
					}
				});
			}
			
			$(document).ready(function() {
				$.get('${root}', {'action': 'getModules'}, function(response) {
					var module = _.template($('#template-module').html());
					var tbody = $('#modules table tbody');
					
					_.each(response.payload, function(element, index, list) {
						tbody.append(module(element));
						updateModule(element.id, element.started);
					});
					
					finishBox();
				});
				
				$.get('${root}', {'action': 'getRegistryLocation'}, function(response) {
					$('input[name="location"]').val(response.payload);
					
					finishBox();
				});
				
				updateLog();
				
				setInterval(function() {
					updateLog();
				}, 1000);
				
				$('#modules').on('click', '.start', {'action': 'startModule'}, actionHandler);
				
				function actionHandler(event) {
					var action = event.data.action;
					var id = $(this).closest('tr').data('id');
					var self = this;
					
					self.disabled = true;
					
					$.get('${root}', {'action': action, 'id': id}, function(response) {
						if (response.error == 0) {
							switch (action) {
							case 'startModule':
								updateModule(id, true);
								break;

							case 'stopModule':
								updateModule(id, false);
								break;
							}
						}
						
						self.disabled = false;
					});
				}
				
				$('#registry form').submit(function(event) {
					event.preventDefault();
				});
				
				$('input[name="location"]').blur(function() {
					$.get('${root}', {'action': 'updateRegistryLocation', 'location': $(this).val()});
				});
			});
		</script>
	</head>
	
	<body>
		<div id="main">
			<div id="header">
				<div id="logo"></div>
				<h1>ProtoCom<span class="subtitle">Performance Prototype</span></h1>
			</div>

			<div id="registry" class="box">
				<h2>Registry Location</h2>

				<form action="#">
					<input class="input" type="text" name="location">
				</form>

				<div class="note">Modules (except the registry) use the registry location at startup.</div>
			</div>

			<div id="modules" class="box">
				<h2>Modules</h2>

				<table>
					<col class="name-column">
					<col class="state-column">
					<col class="actions-column">

					<thead>
						<tr>
							<th>Name</th>
							<th>State</th>
							<th>Actions</th>
						</tr>
					</thead>

					<tbody>
					</tbody>
				</table>
			</div>

			<div id="log" class="box">
				<h2>Local Log</h2>

				<form>
					<textarea readonly id="messages"></textarea>
				</form>
			</div>
		</div>
	</body>
</html>