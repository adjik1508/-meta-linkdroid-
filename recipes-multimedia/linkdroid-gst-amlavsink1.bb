SUMMARY = "GStreamer AML AVsink plugin"
#  Amlogic GStreamer plugins to send audio es to aml dsp and video es to aml hw decoder. 
#  decode and render will be complete at kernel level.
SECTION = "multimedia"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(alien5)$"

inherit lib_package pkgconfig

### TODO:
## cram plugins as did not have time to check which ones provide gst/video headers 
## QA still complains about host headers used, does not make any sense
DEPENDS = " gstreamer1.0 linkdroid-libamcodec-alien5 linkdroid-libamavutils-alien5 gstreamer1.0-libav gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-ugly"


SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/amlogic-libs/master/gst-aml-plugins-1.0.zip"

SRC_URI[md5sum] = "f19f8f4ee0b24989c06c891ed7f0369c"
SRC_URI[sha256sum] = "7b62c12f1c8d63751c167101a6f566e22eb40929932af1c76edb51f192a99108"

S = "${WORKDIR}/gst-aml-plugins-1.0"

do_install() {
    install -d ${D}${libdir}
    install -d ${D}${libdir}/gstreamer-1.0
    install -m 0755  ${WORKDIR}/gst-aml-plugins-1.0/libgstamlasink.so  ${D}${libdir}/gstreamer-1.0
    install -m 0755  ${WORKDIR}/gst-aml-plugins-1.0/libgstamlvsink.so  ${D}${libdir}/gstreamer-1.0
    install -m 0755  ${WORKDIR}/gst-aml-plugins-1.0/libgstamladec.so  ${D}${libdir}/gstreamer-1.0
    install -m 0755  ${WORKDIR}/gst-aml-plugins-1.0/libgstamlvdec.so  ${D}${libdir}/gstreamer-1.0
}

FILES_${PN} += "${libdir}/*"
FILES_${PN}-dev = ""
do_configure() {
}

do_compile() {
}

do_package_qa() {
}

SSTATE_DUPWHITELIST += "${STAGING_DIR}${libdir}/gst-aml-plugins-1.0/libgstamlasink.so"
SSTATE_DUPWHITELIST += "${STAGING_DIR}${libdir}/gst-aml-plugins-1.0/libgstamlvsink.so"
SSTATE_DUPWHITELIST += "${STAGING_DIR}${libdir}/gst-aml-plugins-1.0/libgstamladec.so"
SSTATE_DUPWHITELIST += "${STAGING_DIR}${libdir}/gst-aml-plugins-1.0/libgstamlvdec.so"
