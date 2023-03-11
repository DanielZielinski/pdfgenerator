<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:fo="http://www.w3.org/1999/XSL/Format"
				xmlns:doc="http://pdfgenerator.zielinski.daniel">
	<xsl:output method="xml" indent="yes"/>
	<xsl:template match="/doc:CvDocument">
		<fo:root>
			<fo:layout-master-set>
				<fo:simple-page-master master-name="A4-portrait">
					<fo:region-body margin-top="20pt"/>
					<fo:region-after extent="2cm"/>
					<fo:region-start background-color="#44a0b7" extent="48%"/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="A4-portrait" page-height="29.7cm" page-width="21.0cm">
				<fo:flow flow-name="xsl-region-body">
					<fo:block height="29cm" font-family="Helvetica" font-style="normal">
						<fo:inline-container inline-progression-dimension="2%">
							<fo:block>
							</fo:block>
						</fo:inline-container>
						<fo:inline-container inline-progression-dimension="46%">
							<xsl:apply-templates select="doc:personalData"/>
						</fo:inline-container>
						<fo:inline-container inline-progression-dimension="52%">
							<fo:block>
								<fo:inline-container inline-progression-dimension="5%">
									<fo:block>
									</fo:block>
								</fo:inline-container>
								<fo:inline-container inline-progression-dimension="95%">
									<fo:block font-size="18pt" font-weight="normal" font-family="LatoHeavy">
										<fo:inline>Experience</fo:inline>
									</fo:block>
								</fo:inline-container>
							</fo:block>
							<fo:block>
								<fo:inline-container inline-progression-dimension="2%">
									<fo:block>
									</fo:block>
								</fo:inline-container>
							</fo:block>
							<xsl:apply-templates select="doc:experienceList/doc:experience"/>
							<fo:block margin-top="10pt">
								<fo:inline-container inline-progression-dimension="5%">
									<fo:block>
									</fo:block>
								</fo:inline-container>
								<fo:inline-container inline-progression-dimension="95%">
									<fo:block font-size="18pt" font-weight="normal" font-family="LatoHeavy">
										<fo:inline>Education</fo:inline>
									</fo:block>
								</fo:inline-container>
							</fo:block>
							<xsl:apply-templates select="doc:educationList/doc:education"/>
						</fo:inline-container>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template match="/doc:CvDocument/doc:personalData">

		<fo:block color="#44a0b7">""</fo:block>
		<fo:block>
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="78%">
				<fo:block text-align="center">
					<fo:external-graphic
							src="src/main/resources/images/avatar-placeholder.png" content-height="scale-to-fit" height="2.00in"  content-width="2.00in"/>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
		</fo:block>

		<fo:block>
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="78%">
				<fo:block text-align="center" font-size="18pt" font-weight="normal" font-family="LatoMedium" color="black">
					<xsl:value-of select="concat(doc:firstName , ' ', doc:lastName)"/>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
		</fo:block>

		<fo:block>
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="78%">
				<fo:block text-align="center" font-size="18pt" font-weight="normal" font-family="LatoMedium" color="white">
					<xsl:value-of select="doc:jobPosition"/>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
		</fo:block>

		<fo:block margin-top="30pt">
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="70%">
				<fo:block font-size="12pt" color="black" font-weight="normal" font-family="LatoLight">
					<xsl:value-of select="doc:email"/>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
					<fo:inline font-family="FontAwesome" color="white">
						&#xf0e0;
					</fo:inline>
				</fo:block>
			</fo:inline-container>
		</fo:block>

		<fo:block margin-top="20pt">
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="70%">
				<fo:block font-size="12pt" color="black" font-weight="normal" font-family="LatoLight">
					<xsl:value-of select="doc:phoneNumber"/>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
					<fo:inline font-family="FontAwesome" color="white">
						&#xf095;
					</fo:inline>
				</fo:block>
			</fo:inline-container>
		</fo:block>

		<fo:block margin-top="20pt">
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="70%">
				<fo:block font-size="12pt" color="black" font-weight="normal" font-family="LatoLight">
					<xsl:value-of select="doc:firstAddressLine"/>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="11%">
				<fo:block>
					<fo:inline font-family="FontAwesome" color="white">
						&#xf007;
					</fo:inline>
				</fo:block>
			</fo:inline-container>
		</fo:block>

	</xsl:template>

	<xsl:template match="/doc:CvDocument/doc:educationList/doc:education">
		<fo:block margin-top="5pt">
			<fo:inline-container inline-progression-dimension="5%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="90%">
				<fo:block margin-top="3pt" font-size="10pt" font-weight="normal" font-family="LatoMedium">
					<xsl:value-of select="doc:school"/>
				</fo:block>
			</fo:inline-container>
		</fo:block>
		<fo:block>
			<fo:inline-container inline-progression-dimension="5%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="90%">
				<fo:block margin-top="3pt" font-size="10pt" font-weight="normal" font-family="LatoMedium">
					<xsl:value-of select="concat(doc:dateFrom, ' | ', doc:dateTo)"/>
				</fo:block>
			</fo:inline-container>
		</fo:block>
	</xsl:template>

	<xsl:template match="/doc:CvDocument/doc:experienceList/doc:experience">
		<fo:block margin-top="5pt">
			<fo:inline-container inline-progression-dimension="5%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="95%">
				<fo:block margin-top="3pt" font-size="12pt" font-weight="normal" font-family="LatoMedium">
					<xsl:value-of select="doc:jobPosition"/>
				</fo:block>
			</fo:inline-container>
		</fo:block>
		<fo:block>
			<fo:inline-container inline-progression-dimension="5%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="90%">
				<fo:block margin-top="3pt" font-size="10pt" font-weight="normal" font-family="LatoMedium">
					<xsl:value-of select="concat(doc:companyName, ' | ', doc:dateFrom, ' | ', doc:dateTo)"/>
				</fo:block>
			</fo:inline-container>
		</fo:block>
		<fo:block>
			<fo:inline-container inline-progression-dimension="5%">
				<fo:block>
				</fo:block>
			</fo:inline-container>
			<fo:inline-container inline-progression-dimension="90%">
				<fo:block margin-top="3pt" font-size="10pt" font-weight="normal" font-family="LatoLight" text-align="justify">
					<xsl:value-of select="doc:jobDescription"/>
				</fo:block>
			</fo:inline-container>
		</fo:block>
	</xsl:template>


</xsl:stylesheet>