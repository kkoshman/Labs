<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Info Collection</h2>
  <xsl:apply-templates/>
  </body>
  </html>
</xsl:template>

<xsl:template match="cd">
  <p>
  <xsl:apply-templates select="info"/>
  <xsl:apply-templates select="price"/>
  </p>
</xsl:template>

<xsl:template match="info">
  Title: <span style="color:#ff0000">
  <xsl:value-of select="."/></span>
  <br />
</xsl:template>

<xsl:template match="price">
    Price: <h4>
  <xsl:value-of select="."/></h4>
  <br />
</xsl:template>

</xsl:stylesheet>