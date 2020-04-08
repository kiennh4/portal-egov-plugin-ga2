<div class="column1" id="main-content" role="main">
	#if ($browserSniffer.isIe($request) && $browserSniffer.getMajorVersion($request) < 8)
		<table class="portlet-layout container">
		<tr>
			<td class="aui-w100 portlet-column portlet-column-only" id="column-1">
				$processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")
			</td>
		</tr>
		</table>
	#else
		<div class="portlet-layout container">
			<div class="aui-w100 portlet-column portlet-column-only" id="column-1">
				$processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")
			</div>
		</div>
	#end
</div>